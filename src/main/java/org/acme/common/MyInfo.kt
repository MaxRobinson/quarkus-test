package org.acme.common

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class MyInfo(val who: String="defaultCtr", val more: String ="defaultCtr")