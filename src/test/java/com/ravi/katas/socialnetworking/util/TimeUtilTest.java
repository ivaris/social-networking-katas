package com.ravi.katas.socialnetworking.util;

import com.ravi.katas.socialnetworking.service.TimeLineService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimeUtilTest {
  TimeUtil timeUtil;
  LocalDateTime time;
  @Before
  public void setup(){
    timeUtil = new TimeUtil();
    time= LocalDateTime.now();
  }
  @After
  public void tearup(){
    timeUtil = null;
    time= null;

  }
  @Test(expected=RuntimeException.class)
  public void testTimeDifferenceInSeconds_RuntimeException(){
    assert timeUtil.getDifference(time.minusSeconds(15),time).equalsIgnoreCase("15 seconds ago");
  }
  @Test
  public void testTimeDifferenceInSeconds(){
    assert timeUtil.getDifference(time, time.minusSeconds(15)).equalsIgnoreCase("15 seconds ago");
    assert timeUtil.getDifference(time, time.minusSeconds(150)).equalsIgnoreCase("2 minutes ago");
  }
  @Test
  public void testTimeDifferenceInMinutes(){
    assert timeUtil.getDifference(time, time.minusMinutes(5)).equalsIgnoreCase("5 minutes ago");
    assert timeUtil.getDifference(time, time.minusMinutes(60)).equalsIgnoreCase("1 hours ago");
  }
  @Test
  public void testTimeDifferenceInHours(){
    assert timeUtil.getDifference(time, time.minusHours(5)).equalsIgnoreCase("5 hours ago");
    assert timeUtil.getDifference(time, time.minusHours(24)).equalsIgnoreCase("1 days ago");
  }
  @Test
  public void testTimeDifferenceInDays(){
    assert timeUtil.getDifference(time, time.minusDays(5)).equalsIgnoreCase("5 days ago");
  }
  @Test
  public void testTimeDifferenceInYears(){
    assert timeUtil.getDifference(time, time.minusYears(5)).equalsIgnoreCase("5 years ago");
  }
}
