# DialogHub 

[![Release](https://jitpack.io/v/ElyteLabs/DialogHub.svg)](https://jitpack.io/#ElyteLabs/DialogHub)

DialogHub is a library for easy selection of images, fonts, and colors`

## Features

- **Image Selector Dialog:** Choose background images for your app.
- **Font Style Dialog:** Pick fonts for TextViews dynamically.
- **Color Picker Dialog:** Select colors dynamically for UI elements.


## Installation

### Step 1. Add the JitPack repository to your root build.gradle

    
    dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
            mavenCentral()
            maven { url 'https://jitpack.io' }
        }
    }

### Step 2. Add the dependency


`dependencies {
    implementation 'com.github.ElyteLabs:DialogHub:Tag
}` 

Replace `Tag` with the latest version from the Releases page.

## Usage

### 1. Image Selector Dialog


    val backgrounds = listOf(R.drawable.bg11, R.drawable.bg22, R.drawable.bg5)
    
    val selectorDialog = ImageSelectorDialog(this)
    selectorDialog.setBackgroundsList(backgrounds = backgrounds)
    selectorDialog.setImageSelectedListener(object : ImageSelectorDialog.ImagePickerListener{
        override fun onImageSelected(imageResource: Int) {
            rootLayout.setBackgroundResource(imageResource)
        }
    
        override fun onColorSelected(color: Int) {
            rootLayout.setBackgroundColor(color)
        }
    })
    selectorDialog.showImageSelectionDialog()`

### 2. Font Style Dialog

    val fonts = listOf(R.font.righteous, R.font.salsa, R.font.schoolbell, R.font.sofadi_one)
    
    val styleDialog = FontStyleDialog(this)
    styleDialog.setFontsList(fonts = fonts)
    styleDialog.setFontSelectedListener(object : FontStyleDialog.FontPickerListener{
        override fun onFontSelected(font: Int) {
            textView.typeface = ResourcesCompat.getFont(this@MainActivity, font)
        }
    })
    styleDialog.showFontSelectionDialog()

### 3. Color Picker Dialog


    val colorPickerDialog = ColorPickerDialog(this)
    colorPickerDialog.setColorSelectedListener(object : ColorPickerDialog.ColorPickerListener{
        override fun onColorSelected(color: Int) {
            rootLayout.setBackgroundColor(color)
        }
    })
    colorPickerDialog.showColorPickerDialog()

## License

DialogHub is licensed under the Apache 2.0 License. See the [LICENSE](https://www.apache.org/licenses/LICENSE-2.0.txt) file for details.
