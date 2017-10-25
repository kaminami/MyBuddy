# MyBuddy
a helper library for MyBatis

## Requirements

* [Groovy](http://groovy.codehaus.org/)

## Usage
```groovy
import net.devgoodies.query.*

ExpandoInstaller.instance.install()

def sortConditionArray = 'abc'.desc() + 'xyz'.asc()
sortConditionArray.toOrderByString() 
// abc DESC, xyz ASC
```

```groovy
import net.devgoodies.query.*

def builder = new WhereConditionBuilder()
builder.whereEquals('name', 'foo')
builder.whereIn('id', [1, 3, 5])
builder.toString() 

// (name = 'foo') AND (id IN (1, 3, 5))
```


### Gradle build.gradle example
```groovy
# build.gradle (minimum)
apply plugin: 'groovy'

repositories {
    jcenter()

    maven { 
        url 'https://github.com/kaminami/MyBuddy/raw/master/repository' 
    }
}

dependencies {
    compile 'org.codehaus.groovy:groovy-all:2.4.12'
    compile 'net.devgoodies:mybuddy:1.0.1'
}
```