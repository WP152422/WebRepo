/**
 * 
 */
package org.dimigo.api;

import java.util.Map;

/**
 * <pre>
 * org.dimigo.api
 *   |_ Player
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 27.
 * </pre>
 *
 * @author : Hvid
 * @version : 1.0
 */
public class Player {
	String name;
	String id;

	String height;
	String weight;
	String position;
	String number;
	Map<String, Double> total;
	Map<String, Double> average;

	public Player() {

	}

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(long height) {
		long tmp = height;
		tmp *= 2.54;
		this.height = Long.toString(tmp);
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		long tmp = weight;
		tmp *= 0.453592;
		this.weight = Long.toString(tmp);
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	public Map<String, Double> getTotal() {
		return total;
	}

	public void setTotal(Map<String, Double> total) {
		this.total = total;
	}

	public Map<String, Double> getAverage() {
		return average;
	}

	public void setAverage(Map<String, Double> average) {
		this.average = average;
	}
}
