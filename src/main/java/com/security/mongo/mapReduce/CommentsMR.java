package com.security.mongo.mapReduce;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.Mongo;


public class CommentsMR {
	// Nombre Commentaires

	public static String nombreCommentaires(Mongo mongo) {
		try {
			DB db = mongo.getDB("jciDb");

			DBCollection posts = db.getCollection("comment");

			int max = 42;
			String map = "function() { " + " emit(\"a\", {count : 1});}";

			String reduce = "function(key, values) { " + "total = 0; "
					+ "for(var i in values) { " + "total+= values[i].count ;"
					+ "}" + "return {count : total};} ";


			MapReduceCommand cmd = new MapReduceCommand(posts, map, reduce,
					null, MapReduceCommand.OutputType.INLINE, null);

			MapReduceOutput out = posts.mapReduce(cmd);

			for (DBObject o : out.results()) {
			/*	
				 String json = JSON.serialize( o );
			      
				BasicBSONDecoder decoder = new BasicBSONDecoder();
				BSONObject bsonObject = decoder.readObject(json);
				String json_string = bsonObject.toString();
				
				 JSONObject obj = JSON.serialize(o);
				
				 JSONArray array = (JSONArray)json;
		         System.out.println("The 2nd element of array");
		         System.out.println(array.get(1));
		         System.out.println();
		      */
		         String s = o.toString();
				String[] str1Array = s.split(":", 4);
				String[] str2Array = str1Array[3].split("}", 2);
				String[] str3Array = str2Array[0].split(".", 2);
				System.out.println(str3Array[1]);

			}
			return (".");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ("Error");

		}
	}
	public static void main(String[] args) {


		try {
			Mongo mongo;
			mongo = new Mongo("localhost", 27017);
			System.out.println("Nombre Commentaires :");
			System.out.println(nombreCommentaires(mongo));

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
