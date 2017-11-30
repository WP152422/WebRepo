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

	long height;
	long weight;
	String position;
	String college;
	String birthdate;
	Map<String, Double> total;
	Map<String, Double> average;

	public Player() {

	}

	public Player(String name, String id) {
		this.name = name;
		this.id = id;
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

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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
