package designPatterns;

abstract class Logger {
    Logger logger;
    static Integer infoLevel = 1;
    static Integer debugLevel = 2;
    static Integer errorLevel = 3;
    Logger(Logger logger) {
        this.logger = logger;
    }

    void log(int logLevel, String text) {
        if (logger != null) {
            logger.log(logLevel, text);
        }
    }
}

class InfoLogger extends Logger {
    InfoLogger(Logger logger) {
        super(logger);
    }

    void log(int loglevel, String txt) {
        if (infoLevel == loglevel) {
            System.out.println("info level: " + txt);
        } else {
            logger.log(loglevel, txt);
        }
    }

}

class ErrorLogger extends Logger {
    ErrorLogger(Logger logger) {
        super(logger);
    }

    void log(int loglevel, String txt) {
        if (errorLevel == loglevel) {
            System.out.println("error level: " + txt);
        } else {
            logger.log(loglevel, txt);
        }
    }
}

class DebugLogger extends Logger {
    DebugLogger(Logger logger) {
        super(logger);
    }

    void log(int loglevel, String txt) {
        if (debugLevel == loglevel) {
            System.out.println("debug level: " + txt);
        } else {
            logger.log(loglevel, txt);
        }
    }
}
public class ChainOfReactionsPattern {
    public static void main(String args[]) {
        Logger logger = new InfoLogger(new DebugLogger(new ErrorLogger(null)));
        logger.log(1, "hello i'm info logger");
    }
}
