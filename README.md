# Óbudai Egyetem Java microservice project 

## Openapi kódgenerátor
Hogyan tudunk egy szabványos végpont leíró definícióból az alkalmazásban is használható interface és kommunikációs objektum forráskódokat generálni.

[youtube](https://youtu.be/VveuzT7B97k)

maven plugin
```
 <plugin>
                <groupId>org.openapitools</groupId>
                <artifactId>openapi-generator-maven-plugin</artifactId>
                <version>${openapi-generator-maven-plugin.version}</version>
                <executions>
                    <execution>
                        <phase>clean</phase>
                        <id>generate-java</id>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <skipValidateSpec>true</skipValidateSpec>
                            <inputSpecRootDirectory>${project.basedir}/src/main/resources/openapi
                            </inputSpecRootDirectory>
                            <output>${project.build.sourceDirectory}</output>
                            <generatorName>spring</generatorName>

                            <apiPackage>hu.oe.yokudlela.${project.artifactId}.generated.rest.api</apiPackage>
                            <modelPackage>hu.oe.yokudlela.${project.artifactId}.generated.rest.model</modelPackage>
                            <invokerPackage>hu.oe.yokudlela.${project.artifactId}.generated.rest.invoker</invokerPackage>

                            <addCompileSourceRoot>true</addCompileSourceRoot>
                            <generateApiTests>false</generateApiTests>
                            <generateModelTests>false</generateModelTests>
                            <generateSupportingFiles>false</generateSupportingFiles>
                            <languageSpecificPrimitives>String,int,boolean,Double</languageSpecificPrimitives>
                            <typeMappings>array=List,map=Map,string=String,integer=int,number=Double</typeMappings>
                            <additionalProperties>
                                <useLombok>true</useLombok>
                            </additionalProperties>
                            <configOptions>
                                <interfaceOnly>true</interfaceOnly>
                                <skipDefaultInterface>true</skipDefaultInterface>
                                <sourceFolder>/</sourceFolder>
                                <additionalModelTypeAnnotations>
                                    @lombok.Data
                                    @lombok.NoArgsConstructor
                                    @lombok.AllArgsConstructor
                                    @lombok.Builder
                                </additionalModelTypeAnnotations>

                                <skipValidateSpec>false</skipValidateSpec>
                                <useTags>true</useTags>
                                <useJakartaEe>true</useJakartaEe>
                                <dateLibrary>java8-localdatetime</dateLibrary>
                                <reactive>false</reactive>
                                <useBeanValidation>true</useBeanValidation>
                                <useSpringSecurity>true</useSpringSecurity>
                                <useOptional>false</useOptional>
                                <generatedConstructorWithRequiredArgs>false</generatedConstructorWithRequiredArgs>
                                <generatedConstructorWithNoArgs>false</generatedConstructorWithNoArgs>
                                <performBeanValidation>true</performBeanValidation>
                                <generateApis>false</generateApis>
                            </configOptions>
                            <typeMappings>LocalDate=Date</typeMappings>
                            <importMappings>
                                <importMapping>Date=java.util.Date</importMapping>
                            </importMappings>

                        </configuration>
                    </execution>
                </executions>
            </plugin>
```

# Kapcsolódó tartalmak:

Java annotációk: https://www.w3schools.com/java/java_annotations.asp

Springboot start: https://www.baeldung.com/spring-boot-start

Openapi specifikáció: https://swagger.io/specification/

Lombok: https://projectlombok.org/
