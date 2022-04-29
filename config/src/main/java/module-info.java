module com.ssi.clean.example.config {
	exports com.ssi.clean.config;

	requires com.ssi.clean.example.usecase;
	requires com.ssi.clean.example.entities;
	requires com.ssi.clean.example.jug;
	requires com.ssi.clean.example.uuid;
	requires com.ssi.clean.example.db.simple;
	requires com.ssi.clean.example.db.hazelcast;
	requires com.ssi.clean.example.encoder;
}
