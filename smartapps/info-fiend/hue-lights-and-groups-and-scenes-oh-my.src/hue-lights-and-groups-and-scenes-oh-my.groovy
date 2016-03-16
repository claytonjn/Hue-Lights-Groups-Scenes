 Welcome back, claytonjn@gmail.com
Logout
My Locations
My Hubs
My Devices
My SmartApps
My Device Handlers
My Publication Requests
Live Logging
Documentation
× SmartApp published successfully for me
File Explorer     
css
i18n
images
javascript
src
views
hue-lights-and-groups-and-scenes-oh-my.groovy
Hue Lights and Groups and Scenes (OH MY) SavePublishIDE SettingsApp SettingsSimulator 

1357
            state.groups.unique {it.id}.each { group ->
1358
                map << ["${group.id}g":["id":group.id+"g", "name":group.name, "hub":group.hub]]
1359
            }
1360
            state.group = map
1361
        }
1362
    }
1363
    catch(Exception e) {
1364
        log.error "Caught error attempting to convert group list to map: $e"
1365
    }
1366
}
1367
​
1368
def convertSceneListToMap() {
1369
    log.debug "CONVERT LIST"
1370
    try {
1371
        if (state.scenes instanceof java.util.List) {
1372
            def map = [:]
1373
            state.scenes.unique {it.id}.each { scene ->
1374
                map << ["${scene.id}s":["id":scene.id+"s", "name":scene.name, "hub":scene.hub]]
1375
            }
1376
            state.scene = map
1377
        }
1378
    }
1379
    catch(Exception e) {
1380
        log.error "Caught error attempting to convert scene list to map: $e"
1381
    }
1382
}
1383
​
1384
private String convertHexToIP(hex) {
1385
    [convertHexToInt(hex[0..1]),convertHexToInt(hex[2..3]),convertHexToInt(hex[4..5]),convertHexToInt(hex[6..7])].join(".")
1386
}
1387
​
1388
private Boolean hasAllHubsOver(String desiredFirmware)
1389
{
1390
    return realHubFirmwareVersions.every { fw -> fw >= desiredFirmware }
1391
}
1392
​
1393
private List getRealHubFirmwareVersions()
1394
{
1395
    return location.hubs*.firmwareVersionString.findAll { it }
1396
}
1397
​
1398
​
1399
def ipAddressFromDni(dni) {
1400
    if (dni) {
1401
        def segs = dni.split(":")
1402
        convertHexToIP(segs[0]) + ":" +  convertHexToInt(segs[1])
1403
    } else {
1404
        null
1405
    }
1406
}
1407
​
1408
def getSelectedTransition() {
1409
    return settings.selectedTransition
1410
}
1411
​
1412
int kelvinToMireks(kelvin) {
1413
    return 1000000 / kelvin //https://en.wikipedia.org/wiki/Mired
1414
}
ClearLogs
Browse SmartApp Templates 
Location
