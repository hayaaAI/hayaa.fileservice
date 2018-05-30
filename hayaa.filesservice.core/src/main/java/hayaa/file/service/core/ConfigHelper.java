package hayaa.file.service.core;

import Hayaa.ConfigSeed.ConfigTool;

class ConfigHelper extends ConfigTool<OssConfig,OssConfigRoot> {
     public static ConfigHelper getInstance() {
         return _instance;
     }

     private static ConfigHelper _instance = new ConfigHelper();
     private ConfigHelper(){
         super(DefineTable.OssServiceComponentID,OssConfig.class,OssConfigRoot.class);
     }
}
