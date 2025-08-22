# SmartAnimUtils

A lightweight Android library providing 30 ready-to-use animations for Views.

---

## Features

- 30 built-in animations (fade, bounce, zoom, slide, rotate, shake, etc.)
- Easy integration with any `View`
- Optional custom duration
- `resetAnimations` method to reset any applied transformations
- Lightweight and fast

---

## Installation

### Step 1: Add JitPack repository

In your **root `settings.gradle`**:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add the dependency

In your **app module `build.gradle`**:

```gradle
dependencies {
    implementation 'com.github.aakashsakhalkar:SmartAnimUtils:1.0.1'
}
```

---

## Usage

```java
import com.aakash.smartanimutils.SmartAnimUtils;

View view = findViewById(R.id.myView);

// Apply Bounce animation
SmartAnimUtils.animate(view, SmartAnimUtils.AnimationType.BOUNCE);

// Reset any applied animation
SmartAnimUtils.resetAnimations(view);

// Custom duration (1 second)
SmartAnimUtils.animate(view, SmartAnimUtils.AnimationType.BOUNCE, 1000);
```

### All Animations

```java
// Show / Hide
SmartAnimUtils.animateShowFromCenter(view, 600);
SmartAnimUtils.animateHideToCenter(view, 600);

// Slide In
SmartAnimUtils.animSlideInFromLeft(view, 600);
SmartAnimUtils.animSlideInFromRight(view, 600);
SmartAnimUtils.animSlideInFromTop(view, 600);
SmartAnimUtils.animSlideInFromBottom(view, 600);

// Slide Out
SmartAnimUtils.slideOutLeft(view, 600);
SmartAnimUtils.slideOutRight(view, 600);
SmartAnimUtils.slideOutUp(view, 600);
SmartAnimUtils.slideOutDown(view, 600);

// Fade
SmartAnimUtils.fadeIn(view, 600);
SmartAnimUtils.fadeOut(view, 600);

// Zoom
SmartAnimUtils.zoomIn(view, 600);
SmartAnimUtils.zoomOut(view, 600);

// Rotate
SmartAnimUtils.rotateClockwise(view, 600);
SmartAnimUtils.rotateCounterClockwise(view, 600);
SmartAnimUtils.flipHorizontal(view, 600);
SmartAnimUtils.flipVertical(view, 600);

// Bounce / Shake
SmartAnimUtils.bounce(view, 600);
SmartAnimUtils.shake(view, 600);
SmartAnimUtils.animatePopUpBounce(view, 600);
SmartAnimUtils.animatePopUp(view, 600);

// Special Effects
SmartAnimUtils.flash(view, 600);
SmartAnimUtils.blink(view, 600);
SmartAnimUtils.pulse(view, 600);
SmartAnimUtils.swing(view, 600);
SmartAnimUtils.tada(view, 600);
SmartAnimUtils.wobble(view, 600);
SmartAnimUtils.heartbeat(view, 600);
SmartAnimUtils.dropOut(view, 600);

// Reset any animation and transformations
SmartAnimUtils.resetAnimations(view);

```

---

## Developer Info

- Author: Aakash Sakhalkar
- GitHub: [https://github.com/aakashsakhalkar/SmartAnimUtils](https://github.com/aakashsakhalkar/SmartAnimUtils)
- Email: aakashsakhalkar@gmail.com

---

## License

MIT License © 2025 Aakash Sakhalkar

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

The software is provided "as is", without warranty of any kind.

---

## Contribution

Open issues or pull requests on GitHub.

Suggestions for new animations are welcome.


