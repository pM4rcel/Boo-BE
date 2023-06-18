package com.example.booo;

public class StatusCodes {

//    100-199 -> Informational
    public final int SC_CONTINUE = 100;
    public final int SC_SWITCHING_PROTOCOLS = 101;

//    200-299 -> Client request successful
    public final int SC_OK = 200;
    public final int SC_CREATED= 201;
    public final int SC_ACCEPTED = 202;
    public final int SC_NON_AUTHORITATIVE_INFORMATION = 203;
    public final int SC_NO_CONTENT = 204;
    public final int SC_RESET_CONTENT = 205;
    public final int SC_PARTIAL_CONTENT = 206;

//    300-399 -> Client request redirected, further action necessary
    public final int SC_MULTIPLE_CHOICES = 300;
    public final int SC_MOVED_PERMANENTLY = 301;
    public final int SC_MOVED_TEMPORARILY = 302;
    public final int SC_SEE_OTHER = 303;
    public final int SC_NOT_MODIFIED = 304;
    public final int SC_USE_PROXY = 305;

//    400-499 -> Client request incomplete
    public final int SC_BAD_REQUEST = 400;
    public final int SC_UNAUTHORIZED = 401;
    public final int SC_PAYMENT_REQUIRED = 402;
    public final int SC_FORBIDDEN = 403;
    public final int SC_NOT_FOUND = 404;
    public final int SC_METHOD_NOT_ALLOWED = 405;
    public final int SC_NOT_ACCEPTABLE = 406;
    public final int SC_PROXY_AUTHENTICATION_REQUIRED = 407;
    public final int SC_REQUEST_TIMEOUT = 408;
    public final int SC_CONFLICT = 409;
    public final int SC_GONE = 410;
    public final int SC_LENGTH_REQUIRED = 411;
    public final int SC_PRECONDITION_FAILED = 412;
    public final int SC_REQUEST_ENTITY_TOO_LARGE = 413;
    public final int SC_REQUEST_URI_TOO_LONG = 414;
    public final int SC_UNSUPPORTED_MEDIA_TYPE = 415;

//    500-505 -> Server error
    public final int SC_INTERNAL_SERVER_ERROR = 500;
    public final int SC_NOT_IMPLEMENTED = 501;
    public final int SC_BAD_GATEWAY = 502;
    public final int SC_SERVICE_UNAVAILABLE = 503;
    public final int SC_GATEWAY_TIMEOUT = 504;
    public final int SC_HTTP_VERSION_NOT_SUPPORTED = 505;

}
