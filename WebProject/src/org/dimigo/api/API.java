package org.dimigo.api;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.JSONArray;




public class API {
	
	private static final Map<String, String> teamId = new HashMap<String, String>();
	static
	{
		teamId.put("Utah Jazz","583ece50-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Portland Trail Blazers","583ed056-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Los Angeles Lakers","583ecae2-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Los Angeles Clippers","583ecdfb-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Sacramento Kings","583ed0ac-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Houston Rockets","583ecb3a-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Miami Heat","583ecea6-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Toronto Raptors","583ecda6-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Boston Celtics","583eccfa-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Brooklyn Nets","583ec9d6-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Orlando Magic","583ed157-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Washington Wizards","583ec8d4-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Oklahoma City Thunder","583ecfff-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Memphis Grizzlies","583eca88-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Cleveland Cavaliers","583ec773-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("New York Knicks","583ec70e-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("New Orleans Pelicans","583ecc9a-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("San Antonio Spurs","583ecd4f-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Chicago Bulls","583ec5fd-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Detroit Pistons","583ec928-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Philadelphia 76ers","583ec87d-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Milwaukee Bucks","583ecefd-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Minnesota Timberwolves","583eca2f-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Denver Nuggets","583ed102-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Golden State Warriors","583ec825-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Phoenix Suns","583ecfa8-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Dallas Mavericks","583ecf50-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Atlanta Hawks","583ecb8f-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Indiana Pacers","583ec7cd-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Charlotte Hornets","583ec97e-fb46-11e1-82cb-f4ce4684ea4c");

	}
	
	public static void main(String[] args) throws Exception {
//		API.parseBoxScore("76286477-8a66-4080-94c1-a5c067d8f4db", "Boston Celtics");
		API.parseRosters("Boston Celtics");
	}
    
    private static String getJsonTeamProfile(String teamName)
    {
    	try {
            String apiURL = "https://api.sportradar.us/nba/trial/v4/en/teams/" + teamId.get(teamName) +  "/profile.json?api_key=sdakmxjufheq82thgcc4wxft"; // json 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println("getJsonPlayerProfile : " + response);
            return response.toString();
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e);
        }
		return null;
    }
    
    public static Player parsePlayerProfile(String playerId) throws Exception {
    	try {
    		
    		System.out.println("player id : " + playerId);
    		String jsonResult = getJsonPlayerProfile(playerId);
    		
			JSONParser parser = new JSONParser();
			Object obj = parser.parse( jsonResult );
			JSONObject jsonObject = (JSONObject) obj;
			
			Player result = new Player();
			
			result.setId(playerId);
			result.setName((String)jsonObject.get("full_name"));
			result.setHeight((long)jsonObject.get("height"));
			result.setWeight((long)jsonObject.get("weight"));
			result.setPosition((String)jsonObject.get("primary_position"));

			
			JSONArray seasons = (JSONArray)jsonObject.get("seasons");
			JSONArray teams = (JSONArray)((JSONObject)seasons.get(0)).get("teams");
			Map<String, Double> total = (Map<String, Double>)((JSONObject)teams.get(0)).get("total");
			Map<String, Double> avg = (Map<String, Double>)((JSONObject)teams.get(0)).get("average");
			result.setTotal(total);
			result.setAverage(avg);
			

			
			return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("올바른 Player ID를 입력해주십시오");
		}
    }

    public static Map<String, Object> parseRosters(String teamName) throws Exception
    {
    	try {
    		
    		Map<String, Object> result = new HashMap<>();
    		
    		System.out.println("rosters : " + teamName);
    		String jsonResult = getJsonTeamProfile(teamName);
    		
			JSONParser parser = new JSONParser();
			Object obj = parser.parse( jsonResult );
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray coaches = (JSONArray) (jsonObject.get("coaches"));
			StringBuffer coachNames = new StringBuffer();
			coachNames.append((String)((JSONObject)coaches.get(0)).get("full_name"));
			for(int i=1; i<coaches.size(); i++)
			{
				coachNames.append(", ");
				coachNames.append((String)((JSONObject)coaches.get(i)).get("full_name"));
			}
			result.put("coaches", coachNames.toString());
			
			JSONArray players = (JSONArray)(jsonObject.get("players"));
			
			List<Player> PG = new ArrayList<>();
			List<Player> SG = new ArrayList<>();
			List<Player> PF = new ArrayList<>();
			List<Player> SF = new ArrayList<>();
			List<Player> C = new ArrayList<>();
			for(int i=0; i<players.size(); i++)
			{
				JSONObject player = (JSONObject) players.get(i);
				switch((String)player.get("primary_position"))
				{
					case "PG":
						Player pg = new Player((String)player.get("full_name"));
						pg.setHeight((long)player.get("height"));
						pg.setWeight((long)player.get("weight"));
						pg.setNumber((String)player.get("jersey_number"));
						PG.add(pg);
						break;
					case "SG":
						Player sg = new Player((String)player.get("full_name"));
						sg.setHeight((long)player.get("height"));
						sg.setWeight((long)player.get("weight"));
						sg.setNumber((String)player.get("jersey_number"));
						SG.add(sg);
						break;
					case "PF":
						Player pf = new Player((String)player.get("full_name"));
						pf.setHeight((long)player.get("height"));
						pf.setWeight((long)player.get("weight"));
						pf.setNumber((String)player.get("jersey_number"));
						PF.add(pf);
						break;
					case "SF":
						Player sf = new Player((String)player.get("full_name"));
						sf.setHeight((long)player.get("height"));
						sf.setWeight((long)player.get("weight"));
						sf.setNumber((String)player.get("jersey_number"));
						SF.add(sf);
						break;
					case "C":
						Player c = new Player((String)player.get("full_name"));
						c.setHeight((long)player.get("height"));
						c.setWeight((long)player.get("weight"));
						c.setNumber((String)player.get("jersey_number"));
						C.add(c);
						break;
					default:
						throw new Exception((String)player.get("primary_position") + "은 없는 포지션입니다.");
				}
			}
			result.put("PG", PG);
			result.put("SG", SG);
			result.put("PF", PF);
			result.put("SF", SF);
			result.put("C", C);
			
			

			return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
    }
    
    public static Map<String, String> parsePlayers(String teamName) throws Exception
    {
    	try {
    		
    		Map<String, String> result = new HashMap<>();
    		
    		System.out.println("players : " + teamName);
    		String jsonResult = getJsonTeamProfile(teamName);
    		
			JSONParser parser = new JSONParser();
			Object obj = parser.parse( jsonResult );
			JSONObject jsonObject = (JSONObject) obj;
			
			
			JSONArray players = (JSONArray)(jsonObject.get("players"));
			
			for(int i=0; i<players.size(); i++)
			{
				JSONObject player = (JSONObject) players.get(i);
				result.put((String)player.get("full_name"), (String)player.get("id"));
			}
			
			
			

			return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
    }
    
    private static String getJsonSchedule() {
        
        try {
            String apiURL = "https://api.sportradar.us/nba/trial/v4/en/games/2017/REG/schedule.json?api_key=sdakmxjufheq82thgcc4wxft"; // json 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            return response.toString();
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e);
        }
		return null;
    }
    
    public static String parseSchedule(String teamName) throws Exception {
    	try {
    		
    		System.out.println("aaa" + teamName);
    		String jsonResult = getJsonSchedule();
    		
			JSONParser parser = new JSONParser();
			Object obj = parser.parse( jsonResult );
			JSONObject jsonObject = (JSONObject) obj;
			
			
			JSONArray games = (JSONArray) (jsonObject.get("games"));
			
			
			JSONArray result = new JSONArray();
			
			for(int i=0; i<games.size(); i++)
			{
				JSONObject info = (JSONObject) games.get(i);
				String date = (String) info.get("scheduled");
				String home = (String) ((JSONObject) info.get("home")).get("name");
				String away = (String) ((JSONObject) info.get("away")).get("name");
				
				
				if(home.equals(teamName))
				{
					JSONObject calInfo = new JSONObject();
					calInfo.put("title", "vs " + away);
					calInfo.put("start", date.substring(0, 10));
					result.add(calInfo);	
				}
				else if(away.equals(teamName))
				{
					JSONObject calInfo = new JSONObject();
					calInfo.put("title", "vs " + home);
					calInfo.put("start", date.substring(0, 10));
					result.add(calInfo);
				}
			}

			return result.toString();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
    }
    
    private static String getJsonPlayerProfile(String playerId)
    {
    	try {
            String apiURL = "https://api.sportradar.us/nba/trial/v4/en/players/" + playerId + "/profile.json?api_key=sdakmxjufheq82thgcc4wxft"; // json 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            return response.toString();
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e);
        }
		return null;
    }
    
    private static String getJsonDailySchedule()
    {
    	try {
    		Calendar cal = Calendar.getInstance();
    		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
    		String date = fmt.format(cal.getTime());
    		StringBuilder sb = new StringBuilder(date);
    		sb.replace(9, 10, Integer.toString(Integer.parseInt(date.substring(9, 10)) -1)); 
    		date = sb.toString();
    		System.out.println("today is " + date);
            String apiURL = "https://api.sportradar.us/nba/trial/v4/en/games/" + date + "/schedule.json?api_key=sdakmxjufheq82thgcc4wxft"; // json 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                System.out.println(br);
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println("aa" + response);
            return response.toString();
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e);
        }
		return null;
    }

    public static String parseDailySchedule(String teamName) throws Exception {
    	try {
    		
    		String jsonResult = getJsonDailySchedule();
    		
			JSONParser parser = new JSONParser();
			Object obj = parser.parse( jsonResult );
			
			JSONObject jsonObject = (JSONObject) obj;
			
			
			JSONArray games = (JSONArray) (jsonObject.get("games"));
			
			System.out.println("bb" + teamName);
			
			for(int i=0; i<games.size(); i++)
			{
				JSONObject game = (JSONObject) games.get(i);
				JSONObject home = (JSONObject) game.get("home");
				JSONObject away = (JSONObject) game.get("away");
				String homeName = (String) home.get("name");
				String awayName = (String) away.get("name");
				
				System.out.println(i +" " + homeName);
				System.out.println(i +" " +awayName);
				System.out.println((String)game.get("id"));
				
				if(teamName.equals(homeName))
				{
					return awayName + ":" + (String)game.get("id");
				}
				if(teamName.equals(awayName))
				{
					return homeName + ":" + (String)game.get("id");
				}
			}
			return "None";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
    }
    
    private static String getJsonBoxScore(String gameId)
    {
    	try {   	   		
            String apiURL = "https://api.sportradar.us/nba/trial/v4/en/games/" + gameId + "/boxscore.json?api_key=sdakmxjufheq82thgcc4wxft"; // json 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println("mm" + response);
            return response.toString();
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e);
        }
		return null;
    }
    
    public static String parseBoxScore(String gameId, String teamName) throws Exception {
    	try {
    		System.out.println(gameId + ":" + teamName + "ll");
    		String jsonResult = getJsonBoxScore(gameId);
    		
			JSONParser parser = new JSONParser();
			Object obj = parser.parse( jsonResult );
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONObject home = (JSONObject)jsonObject.get("home");
			JSONObject away = (JSONObject)jsonObject.get("away");
			System.out.println("hh"+ home);
			System.out.println("hh" +away);
			String homeName = (String)home.get("market") + " " + (String)home.get("name");
			String awayName = (String)away.get("market") + " " + (String)away.get("name");			
			System.out.println("cc" + homeName);
			System.out.println("cc" + awayName);
			if(teamName.equals(homeName))
			{
				return Long.toString((long)home.get("points")) + ":" + Long.toString((long)away.get("points"));
			}
			if(teamName.equals(awayName))
			{
				return Long.toString((long)away.get("points")) + ":" + Long.toString((long)home.get("points"));
			}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return "error";
    }
    

}