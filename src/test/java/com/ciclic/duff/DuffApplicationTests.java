package com.ciclic.duff;

import com.ciclic.duff.model.Beer;
import com.ciclic.duff.model.TemperatureRange;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DuffApplicationTests {

	@Test
	public void contextLoads() {
	}

    @Test
    public void saveBeerWorks() {
        Beer beer = null;
        //beer = createBeer("Style", -666);
        Assert.assertNotNull(beer);
    }

    @Test
    public void updateBeerWorks() {
        Beer beerOld = new Beer();
        Beer beerNew = beerOld;
        //beerNew = updateBeer(beerOld);
        Assert.assertNotSame(beerOld, beerNew);
    }

    @Test
    public void searchBeerByNameWorks() {
        Beer beer = null;
        //beer = searchBeerByName("NEIPA");
        Assert.assertNotNull(beer);
    }

    @Test
    public void searchBeerByTemperatureWorks() {
        Beer beer = null;
        //beer = searchBeerByTemperature(4);
        Assert.assertNotNull(beer);
    }

    @Test
    public void deleteBeerWorks() {
        Beer beer = new Beer("Deleteme", new TemperatureRange(0, 777));
        //beer = createBeer(beer);
        Beer found = new Beer();
        //found = searchBeerByName("Deleteme");
        Assert.assertNull(found);
    }

}

