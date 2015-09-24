package com.security.mongo.mapReduce;

import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.Mongo;

@Repository
public class AgeUtilisateursMapReduce {
	

	public AgeUtilisateursMapReduce() {
		super();
	
	}

	
	public MapReduceOutput statUtilisateurs() {

		try {
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("jciDb");

			DBCollection books = db.getCollection("utilisateur");

			String map = "function() { " + "var category; "
					+ "if ( this.age >= 30) " + "category = 'grands'; "
					+ "else " + "category = 'petits'; "
					+ "emit(category, {name: this.nom});}";

			String reduce = "function(key, values) { " + "var sum = 0; "
					+ "values.forEach(function(doc) { " + "sum += 1; " + "}); "
					+ "return {Utilisateurs: sum};} ";

			MapReduceCommand cmd = new MapReduceCommand(books, map, reduce,
					null, MapReduceCommand.OutputType.INLINE, null);

			MapReduceOutput out = books.mapReduce(cmd);
			return out;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
