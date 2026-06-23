package org.terracotta.dynamic_config.api.service;

public interface DataDirsEncryption {
  /**
   * Save encryption related information on server.
   */
  void storeInfo(String key, DataDirHolder dataDirHolder);
}
