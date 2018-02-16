package id.ac.ui.cs.advprog.tutorial1.observer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WeatherDataTest {

    private WeatherData weatherData;

    @Before
    public void setUp() throws Exception {
        weatherData = new WeatherData();
        weatherData.setMeasurements(99f, 50f, 10f);
    }

    @Test
    public void testGetTemperature() {
        assertEquals(99f, weatherData.getTemperature(), 0.05);
    }

    @Test
    public void testSetTemperature() {
        weatherData.setTemperature(10f);
        assertEquals(10f, weatherData.getTemperature(), 0.05);
    }

    @Test
    public void testGetHumidity() {
        assertEquals(50f, weatherData.getHumidity(), 0.05);
    }

    @Test
    public void testSetHumidity() {
        weatherData.setHumidity(10f);
        assertEquals(10f, weatherData.getHumidity(), 0.05);
    }

    @Test
    public void testGetPressure() {
        assertEquals(10f, weatherData.getPressure(), 0.05);
    }

    @Test
    public void testSetPressure() {
        weatherData.setPressure(25f);
        assertEquals(25f, weatherData.getPressure(), 0.05);
    }
}