# AntiCheatAPI
If you would like to start an selfmade AntiCheat, this is the API for you!

##Download
https://github.com/HorizonCode/AntiCheatAPI/releases

#Important: plugin.yml
```text
name: Example pluginyml
main: net.example.AntiCheatTest
description: example
version: 1.0
depend: [AntiCheatAPI]
```


##How to use the API?
```java
public class AntiCheatTest extends JavaPlugin {

public AntiCheatAPI ac;		
 
 @Override	
 public void onEnable() {		
  ac = AntiCheatAPI.getNewAPI("Xeno");		
  CheckManager.registerCheck(new Sprint());	
}	
  public AntiCheatAPI getAntiCheat() {		
   return ac;	
  }
}
```
