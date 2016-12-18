# AntiCheatAPI
If you would like to start an selfmade AntiCheat, this is the API for you!

##Download
https://github.com/HorizonCode/AntiCheatAPI/releases

#Important: plugin.yml
```text
name: ExamplePluginYML
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
  ac = AntiCheatAPI.getNewAPI("YourAntiCheatName");		
  CheckManager.registerCheck(new Sprint());	
}	
  public AntiCheatAPI getAntiCheat() {		
   return ac;	
  }
}
```

##How to create a Check?
```java
public class Sprint extends Check {	
public Sprint() {		
super("Sprint");	
}		
  @Override	
  public void onMove(FlagPlayer p, Location from, Location to) {		
   if(p.canBypass())			
    return;		
   if(p.getPlayer().isSprinting() && p.getPlayer().getFoodLevel() < 6){			
    p.flag(this, "tries to sprint while under 3 food bars");		
  }	
 }
}
```
