Feature: Weather

  Scenario: Check correct Weather data
    Given show test name New File

   Scenario: Checking coordinates for city
     Given city "London"
     And country "UK"

     When we are requesting weather data

     Then lon is -0.13
     And lat is 51.51

