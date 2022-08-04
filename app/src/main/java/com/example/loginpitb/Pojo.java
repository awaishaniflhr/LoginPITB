package com.example.loginpitb;

import java.util.ArrayList;

public class Pojo {

public class Auth{
    public String type;
    public ArrayList<Bearer> bearer;
}

public class Bearer{
    public String key;
    public String value;
    public String type;
}

public class Body{
    public String mode;
    public String raw;
}

public class Header{
    public String key;
    public String value;
    public String type;
}

public class Info{
    public String _postman_id;
    public String name;
    public String schema;
}

public class Item{
    public String name;
    public Request request;
    public ArrayList<Object> response;
}

public class Request{
    public Auth auth;
    public String method;
    public ArrayList<Header> header;
    public Body body;
    public Url url;
}

public class Root{
    public Info info;
    public ArrayList<Item> item;
}

public class Url{
    public String raw;
    public String protocol;
    public ArrayList<String> host;
    public ArrayList<String> path;
}

}
