package com.applesoft.util;

import org.joda.time.LocalDate;

/**
 * Created by Sipho on 04/09/2017.
 */
public class DateConverters {
  /**
   * creates a new Date.
   *
   * @return string string
   */
  public static String createDate() {
    return LocalDate.now().toString("yyyy-MM-dd");
  }
}
