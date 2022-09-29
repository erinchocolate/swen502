# Animation
![Animation](https://github.com/erinchocolate/swen502/blob/master/Animation/animationDemo.gif)
## Features:

- Aliens
- Planets
- Animated
- Aliens have different behaviours
  - different speed
  - different size
  - different technology level
- Planets have different attributes
  - different technology level
- Images instead of circles
- Control the animation
  - Start
  - Pause
  - Change speed using Slider

## Continued development

```java
public Alien removeAlien() {
		for(Alien a: ufos) {
			deadAlien = a.fight();
		}
		return deadAlien;
	}

timeline = new Timeline();
		keyFrame = new KeyFrame(Duration.millis(100),(ActionEvent event) ->{
			space.moveAlien();	
			//Remove dead aliens and planets
			layout.getChildren().remove(space.removeAlien());
			layout.getChildren().remove(space.removePlanet());
		});
```

Since the alien moving logic and alien image update are triggered in the animation. There is only one Alien or Planet object that gets removed from the scene each keyframe even though there might be more Aliens and Planets colliding with each other.
