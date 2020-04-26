package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import requesters.WeatherRequester;

public class WeatherStepDefs {
    private String cityName;
    private String country;

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
     public void request_weather(){
        WeatherRequester requester = new WeatherRequester();
        Response response = requester.requestWeather(cityName, country);
        System.out.println(response.getCoord().getLat());
        //System.out.println(requester.requestWeather(cityName, country));
            }

    @Then("lon is {float}")
    public void check_lon(float lon){

    }

    @Then("lat is {float}")
    public void check_lat(float lat){

    }
}
