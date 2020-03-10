package org.acme.totallydifferentpackage

import org.acme.common.MyInfo

class MyData(var hello: String, var info: MyInfo){
    constructor():
        this("default", MyInfo("default", "default"))
}