package pe.mil.microservices.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ProcessConstants {
    public static final String MICROSERVICE_PATH_CONTEXT = "";
    public static final String MICROSERVICE_QUERY_RENIEC_PATH = MICROSERVICE_PATH_CONTEXT + "/reniec";
    public static final String QUERY_RENIEC_PERSON = "/person";
    public static final String QUERY_RENIEC_PERSON_LOG_METHOD = "query.reniec.method";

}
