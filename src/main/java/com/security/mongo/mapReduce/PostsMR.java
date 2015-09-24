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
public class PostsMR {

	public PostsMR() {
		super();
	}

	public MapReduceOutput postsStats() {
		try {
			Mongo mongo = new Mongo("localhost", 27017);

			DB db = mongo.getDB("jciDb");

			DBCollection posts = db.getCollection("post");

			String map = "function() { " + "var OLM; "
					+ "switch ( this.olm ) {" + "case 'ENIT' : "
					+ "OLM = 'ENIT'; " + "break;" + "case 'INSAT' : "
					+ "OLM = 'INSAT'; " + "break;" + "case 'TUNIS' : "
					+ "OLM = 'TUNIS'; " + "break;" + "case 'BEN AROUS' : "
					+ "OLM = 'BEN AROUS'; " + "break;" + "case 'BIZERTE' : "
					+ "OLM = 'BIZERTE'; " + "break;" + "case 'ARIANA' : "
					+ "OLM = 'ARIANA'; " + "break;" + "case 'MANNOUBA' : "
					+ "OLM = 'MANNOUBA'; " + "break;" + "case 'KELIBYA' : "
					+ "OLM = 'KELIBYA'; " + "break;" + "case 'EZZAHRA' : "
					+ "OLM = 'EZZAHRA'; " + "break;" + "case 'BARDO' : "
					+ "OLM = 'BARDO'; " + "break;" + "case 'BOUMHEL' : "
					+ "OLM = 'BOUMHEL'; " + "break;" + "case 'CARTHAGE' : "
					+ "OLM = 'CARTHAGE'; " + "break;" + "case 'EL MENZAH' : "
					+ "OLM = 'EL MENZAH'; " + "break;" + "case 'EL MOUROUJ' : "
					+ "OLM = 'EL MOUROUJ'; " + "break;" + "case 'LA MARSA' : "
					+ "OLM = 'LA MARSA'; " + "break;" + "case 'NABEUL' : "
					+ "OLM = 'NABEUL'; " + "break;" + "case 'RADES' : "
					+ "OLM = 'RADES'; " + "break;" + "case 'LA SOUKRA' : "
					+ "OLM = 'LA SOUKRA'; " + "break;" + "case 'ULT' : "
					+ "OLM = 'ULT'; " + "break;" + "case 'KORBA' : "
					+ "OLM = 'KORBA'; " + "break;" + "case 'HAMMAMET' : "
					+ "OLM = 'HAMMAMET'; " + "break;" + "case 'EL MANAR' : "
					+ "OLM = 'EL MANAR'; " + "break;" + "default : "
					+ "OLM = 'Autres OLMs'; " + "break;" + "}"
					+ "emit(OLM, {contenu: this.contenu});}";

			String reduce = "function(key, values) { " + "var sum = 0; "
					+ "values.forEach(function(doc) { " + "sum += 1; " + "}); "
					+ "return {posts: sum};} ";

			MapReduceCommand cmd = new MapReduceCommand(posts, map, reduce,
					null, MapReduceCommand.OutputType.INLINE, null);

			MapReduceOutput out = posts.mapReduce(cmd);

			// for (DBObject o : out.results()) {
			// String s = o.toString();
			// String[] str1Array = s.split(":", 4);
			// String[] str2Array = str1Array[3].split("}", 2);
			// String[] str3Array = str2Array[0].split(".", 2);
			// String[] str4Array = str1Array[1].split(",", 2);
			//
			// System.out.println(str4Array[0] + " : " + str3Array[1]);
			// }
			return (out);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (null);

		}
	}

}
