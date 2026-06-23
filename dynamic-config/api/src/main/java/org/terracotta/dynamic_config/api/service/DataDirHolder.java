package org.terracotta.dynamic_config.api.service;

import java.util.Collections;
import java.util.List;

public class DataDirHolder {
  private List<String> dataDirs;

  public DataDirHolder(List<String> dataDirs) {
    this.dataDirs = dataDirs;
  }

  public List<String> getDataDirs() {
    return Collections.unmodifiableList(dataDirs);
  }

  public DataDirHolder() {}
}
