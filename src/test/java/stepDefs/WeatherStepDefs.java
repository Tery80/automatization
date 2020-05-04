package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import model.Weather;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherStepDefs {
    private String cityName;
    private String country;
    private Response response;
    @Given("show test name (.*)")
    public void show_test_name(String annotation){
        System.out.println(annotation);
    }

    @Given("city {string}")
    public void set_city(String cityName){
        this.cityName = cityName;
    }

    @Given("country {string}")
    public void set_country(String country){
        this.country = country;
    }

    @When ("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityName, country);

    }

    @Then("lon is {float}")
    public void check_lon(float lon){
        assertEquals(lon,response.getCoord().getLon(), "wrong lon");
    }

    @Then("lat is {float}")
    public void check_lat(float lat){
        assertEquals(lat, response.getCoord().getLat(), "wrong lat");
    }

    @Then("weather is:")
    public void check_weather(Map<String, String> params) {
        Weather weather= response.getWeathers().get(0);
        assertEquals(Long.parseLong(params.get("id")),weather.getId(), "wrong weather id");
        assertEquals(params.get("main"), weather.getMain(),"incorrect weather main");
        assertEquals(params.get("description"),weather.getDescription(),"incorrect weather description");
        assertEquals(params.get("icon"), weather.getIcon(), "incorrect weather item");
    }
     @Then("base is: {string}")
    public void check_base(String base){
        assertEquals(base, response.getBase(), "wrong base");
     }

}
