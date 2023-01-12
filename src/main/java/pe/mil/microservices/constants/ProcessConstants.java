package pe.mil.microservices.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ProcessConstants {

    public static final String PROCESS_TYPE_STRING = "String";
    public static final String PARAM_COMPONENT_UUID = "String";
    public static final String PARAMETER_EMPTY_VALUE = "";
    public static final String PARAMETER_ACTUATOR_PATH_CONTAIN_VALUE = "actuator";
    public static final String MICROSERVICE_PATH_CONTEXT = "";
    public static final String MICROSERVICE_HELLO_PATH = MICROSERVICE_PATH_CONTEXT + "/hello";
    public static final String MICROSERVICE_CUSTOMER_PATH = MICROSERVICE_PATH_CONTEXT + "/customers";
    public static final String MICROSERVICE_QUERY_RENIEC_PATH = MICROSERVICE_PATH_CONTEXT + "/reniec";
    public static final String GET_CUSTOMER_PATH = "";
    public static final String SAVE_CUSTOMER_PATH = "";
    public static final String QUERY_RENIEC_PERSON = "/person";
    public static final String GET_CUSTOMER_ID_PATH = "/{customerId}";
    public static final String GET_SAY_PATH = "/say";

    public static final String FIND_ALL_CUSTOMER_LOG_METHOD = "find.customers.method";
    public static final String FIND_BY_ID_CUSTOMER_LOG_METHOD = "findById.customers.method";
    public static final String SAVE_CUSTOMER_LOG_METHOD = "save.customers.method";
    public static final String UPDATE_CUSTOMER_LOG_METHOD = "update.customers.method";
    public static final String QUERY_RENIEC_PERSON_LOG_METHOD = "query.reniec.method";


    public static final String MAPSTRUCT_COMPONENT_MODEL_CONFIGURATION = "spring";

}
