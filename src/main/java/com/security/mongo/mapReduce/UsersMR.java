package com.security.mongo.mapReduce;

import java.net.UnknownHostException;

import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.Mongo;

@Repository
public class UsersMR {

	// Classification par tranche d'age

	public UsersMR() {
		super();
	}

	public MapReduceOutput classifierAge() {
		try {
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("jciDb");

			DBCollection users = db.getCollection("utilisateur");

			String map_tranche_age = "function() { " + "var category; "
					+ "if ( (this.age >= 14)&(this.age <18) ) "
					+ "category = 'Junior'; "
					+ "else if ( (this.age >=18)&(this.age <40)  ) "
					+ "category = 'Senior'; " + "else if (this.age >=40)"
					+ "category = 'Scénateur'; "
					+ "emit(category, {name: this.nom});}";

			String reduce_tranche_age = "function(key, values) { "
					+ "var sum = 0; " + "values.forEach(function(doc) { "
					+ "sum += 1; " + "}); " + "return {users: sum};} ";

			MapReduceCommand cmd = new MapReduceCommand(users, map_tranche_age,
					reduce_tranche_age, null,
					MapReduceCommand.OutputType.INLINE, null);

			MapReduceOutput out = users.mapReduce(cmd);

//			for (DBObject o : out.results()) {
//
//				String s = o.toString();
//				String[] str1Array = s.split(":", 4);
//				String[] str2Array = str1Array[3].split("}", 2);
//				String[] str3Array = str2Array[0].split(".", 2);
//				String[] str4Array = str1Array[1].split(",", 2);
//
//				System.out.println(str4Array[0] + " : " + str3Array[1]);
//			}
			return (out);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (null);
		}
	}

	// Nombre Utilisateur

	public MapReduceOutput nombreUtilisateurs() {

		try {
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("jciDb");

			DBCollection users = db.getCollection("utilisateur");

			int max = 42;
			String map = "function() { " + " emit(\"a\", {count : 1});}";

			String reduce = "function(key, values) { " + "total = 0; "
					+ "for(var i in values) { " + "total+= values[i].count ;"
					+ "}" + "return {count : total};} ";

			MapReduceCommand cmd = new MapReduceCommand(users, map, reduce,
					null, MapReduceCommand.OutputType.INLINE, null);

			MapReduceOutput out = users.mapReduce(cmd);

//			for (DBObject o : out.results()) {
//				String s = o.toString();
//				String[] str1Array = s.split(":", 4);
//				String[] str2Array = str1Array[3].split("}", 2);
//				String[] str3Array = str2Array[0].split(".", 2);
//				System.out.println(str3Array[1]);
//			}
			return (out);
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
			return (null);
		}

	}

	// Age Max

	public static String ageMax(Mongo mongo) {

		try {
			DB db = mongo.getDB("jciDb");

			DBCollection users = db.getCollection("userModel");

			int max = 42;
			String map = "function() { " + "var max_age=14; "
					+ "if (this.age > max_age) " + "max_age = this.age; "
					+ "emit(max_age, {name: this.nom});}";

			String reduce = "function(key, values) { " + "var sum = 0; "
					+ "values.forEach(function(doc) { " + "sum += 1; " + "}); "
					+ "return {users: sum};} ";

			MapReduceCommand cmd = new MapReduceCommand(users, map, reduce,
					null, MapReduceCommand.OutputType.INLINE, null);

			MapReduceOutput out = users.mapReduce(cmd);

			for (DBObject o : out.results()) {
				System.out.println(o.toString());
			}
			return (".");
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
			return ("Error");

		}

	}

	// public static void main(String[] args) {
	//
	//
	// try {
	// Mongo mongo;
	// mongo = new Mongo("localhost", 27017);
	// System.out.println("Classification par tranche d'âge :");
	// System.out.println(classifierAge(mongo));
	// System.out.println("Nombre Utilisateurs :");
	// System.out.println(nombreUtilisateurs(mongo));
	// // System.out.println("Age Max Ghalta !!!!");
	// // System.out.println(ageMax(mongo));
	// } catch (UnknownHostException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
}
