# Ejército del Perú - Centro de Infromática del Ejército

![GitHub repo size](https://img.shields.io/github/repo-size/dbacilio88/api-ep-cbd-connector-reniec-web-service)
![GitHub repo file count](https://img.shields.io/github/directory-file-count/dbacilio88/api-ep-cbd-connector-reniec-web-service)
![GitHub all releases](https://img.shields.io/github/downloads/dbacilio88/api-ep-cbd-connector-reniec-web-service/total)
[![GitHub contributors](https://img.shields.io/github/contributors/dbacilio88/api-ep-cbd-connector-reniec-web-service)](https://github.com/dbacilio88/api-ep-cbd-connector-reniec-web-service/graphs/contributors)
[![GitHub last commit](https://img.shields.io/github/last-commit/dbacilio88/api-ep-cbd-connector-reniec-web-service?logoColor=success)](https://github.com/dbacilio88/api-ep-cbd-connector-reniec-web-service/graphs/commit-activity)
![GitHub pull requests](https://img.shields.io/github/issues-pr/dbacilio88/api-ep-cbd-connector-reniec-web-service?color=red)
![GitHub language count](https://img.shields.io/github/languages/count/dbacilio88/api-ep-cbd-connector-reniec-web-service)
![GitHub followers](https://img.shields.io/github/followers/dbacilio88?style=social)
[![GitHub watchers](https://img.shields.io/github/watchers/dbacilio88/api-ep-cbd-connector-reniec-web-service?style=social)](https://github.com/dbacilio88/api-ep-cbd-connector-reniec-web-service/watchers)
[![**GitHub Repo stars**](https://img.shields.io/github/stars/dbacilio88/api-ep-cbd-connector-reniec-web-service?style=social)](https://github.com/dbacilio88/api-ep-cbd-connector-reniec-web-service/stargazers)



Plantilla de desarrollo con Spring Boot.

* [Dependencias Externas](#external-dependencies)
* [Dependencias Internas](#internal-dependencies)


    <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>${dependency-javax.servlet-version}</version>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${dependency-org.projectlombok-version}</version>
        </dependency>

        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>${dependency-org.apache.commons-version}</version>
        </dependency>

        <dependency>
            <groupId>javax.json.bind</groupId>
            <artifactId>javax.json.bind-api</artifactId>
            <version>${dependency-javax.json.bind-version}</version>
        </dependency>

        <dependency>
            <groupId>com.google.code.findbugs</groupId>
            <artifactId>annotations</artifactId>
            <version>${dependency-com.google.code.findbugs-version}</version>
            <scope>compile</scope>
        </dependency>

        <dependency>
            <groupId>com.google.code.findbugs</groupId>
            <artifactId>jsr305</artifactId>
            <version>${dependency-com.google.code.findbugs.jsr305-version}</version>
            <scope>compile</scope>
        </dependency>

        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>${dependency-com.google.guava-version}</version>
        </dependency>

        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>${dependency-org.apache.logging.log4j-version}</version>
        </dependency>

        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>${dependency-org.apache.logging.log4j.core-version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>org.mock-server</groupId>
            <artifactId>mockserver-junit-jupiter</artifactId>
            <version>${dependency-org.mock-server-version}</version>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>jakarta.validation</groupId>
                    <artifactId>jakarta.validation-api</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

    </dependencies>


    <dependencies>

        <dependency>
            <groupId>ep.mil.microservices</groupId>
            <artifactId>lib-ep-cbd-microservices-utils-messaging-broker</artifactId>
            <version>1.0.0</version>
        </dependency>

        <dependency>
            <groupId>ep.mil.microservices</groupId>
            <artifactId>lib-ep-cbd-microservices-utils</artifactId>
            <version>1.0.0</version>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-web</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

    </dependencies>

© 2023 Ejército del Perú. All rigths reserved