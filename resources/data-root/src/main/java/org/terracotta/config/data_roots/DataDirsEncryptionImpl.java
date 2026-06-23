package org.terracotta.config.data_roots;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terracotta.dynamic_config.api.service.DataDirHolder;
import org.terracotta.dynamic_config.api.service.DataDirsEncryption;
import org.terracotta.entity.PlatformConfiguration;

public class DataDirsEncryptionImpl implements DataDirsEncryption {

  private static final Logger LOGGER = LoggerFactory.getLogger(DataDirsEncryptionImpl.class);

  private final DataDirsConfig dataDirsConfig;
  private final PlatformConfiguration platformConfiguration;

  public DataDirsEncryptionImpl(DataDirsConfig dataDirsConfig, PlatformConfiguration platformConfiguration) {
    this.dataDirsConfig = dataDirsConfig;
    this.platformConfiguration = platformConfiguration;
  }

  @Override
  public void storeInfo(String key, DataDirHolder dataDirHolder) {
    LOGGER.info("Key is {} and datadirs: {}", key, dataDirHolder.getDataDirs());
    DataDirs dataDirs = dataDirsConfig.getDataDirectoriesForServer(platformConfiguration);
    dataDirHolder.getDataDirs().forEach(name -> dataDirs.setEncryptKey(name, key));
    //dataDirHolder.getDataDirs().forEach(name -> LOGGER.info("Hello {}", dataDirs.getEncryptKey(name).get()));
  }
}
