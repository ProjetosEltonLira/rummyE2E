package portifolio.eltonlira.rummye2e;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite  //Declara que é uma suite de testes
@IncludeEngines("cucumber") // Declara o motor de testes
@SelectClasspathResource("features") //Declara onde estaram os arquivos do GHERKING
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "portifolio.eltonlira.rummye2e")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report.html")
class RummyE2ETests  {


}
