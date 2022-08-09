package com.esanov.librarybackend.base;

public interface BaseURI {

    String API = "/api";
    String V1 = "/v1";
    String V2 = "/v2";

    String API_V1_PATH = API + V1;
    String API_V2_PATH = API + V2;

    String AUTH = "/auth";
    String TOKEN = "/token";
    String PREPARE = "/prepare";
    String PUBLIC = "/public";
    String USER = "/user";
    String BOOK = "/book";
    String AUTHOR = "/author";
    String PUBLISHER = "/publisher";
    String ORDER = "/order";
    String BANK = "/bank";
    String TELEGRAM = "/telegram";

    String UPDATE = "update";
    String FILE = "/file";
    String PROPERTIES = "/properties";
    String ROLE = "/role";
    String PERMISSION = "/permission";
    String BUSINESS = "/business";
    String TRANSACTION = "/transaction";
    String MESSAGE = "/message";
    String BRANCH = "/branch";
    String LIMIT = "/limit";
    String HUMO = "/humo";

    String GET = "/get";
    String ALL = "/all";
    String LIST = "/list";
    String ONE = "/one";
    String ME = "/me";
    String ADD = "/add";
    String EDIT = "/edit";
    String DELETE = "/delete";
    String RESET = "/reset";
    String REFRESH = "/refresh";
    String PASSWORD = "/password";
    String UPLOAD = "/upload";
    String DOWNLOAD = "/download";
    String INFO = "/info";

    String PAY = "/pay";
    String HOLD = "/hold";
    String REVERSE = "/reverse";
    String ATTACH = "/attach";
    String RECO = "/reco";
    String CREATE = "/create";
    String CONFIRM = "/confirm";
    String HISTORY = "/history";
    String SUM = "/sum";
    String STATUS = "/status";
    String CURRENCY = "/currency";
    String CARD = "/card";
    String TYPE = "/type";
    String SEND = "/send";
    String CODE = "/code";
    String TERMINAL = "/terminal";
    String SETTING = "/setting";

    // link
    String FILE_DOWNLOAD_LINK = API_V1_PATH + PUBLIC + FILE + DOWNLOAD;

}
