package com.example.tatianamoura.appbis.SocketJason;

import java.io.Serializable;

public class BSCommandJson implements Serializable {

    public String command;
    public String FilterType;
    public String JsonObject;
    public String ErrorMessage;



    public BSCommandJson() {
    }


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getFilterType() {
        return FilterType;
    }

    public void setFilterType(String filterType) {
        FilterType = filterType;
    }

    public String getJsonObject() {
        return JsonObject;
    }

    public void setJsonObject(String jsonObject) {
        JsonObject = jsonObject;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }
}