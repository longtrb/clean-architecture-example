module com.ssi.clean.example.usecase {
	exports com.ssi.clean.example.usecase;
	exports com.ssi.clean.example.usecase.exception;
	exports com.ssi.clean.example.usecase.port;

	requires com.ssi.clean.example.entities;
	requires org.apache.commons.lang3;
}
