package com.joona.spring.mvc.components;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class ConnectionMetaData {
    private String driver = "org.postgresql.Driver";
    private String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
    private String schema = "local_pg;";
    private String userName = "localuser";
    private String password = "passw0rd";

}
