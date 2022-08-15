package com.esanov.librarybackend.base;

public interface MessageKey {

    // common
    String UNAUTHORIZED = "common.invalid.token";
    String INCORRECT_SMS_CODE = "common.incorrect.sms.code";
    String SUCCESS = "common.success";
    String ERROR = "common.error";
    String INTERNAL_SERVER_ERROR = "common.internal.server.error";
    String EMPTY_DATA = "common.empty.data";
    String INVALID_DATA = "common.invalid.data";
    String VERIFY_TIME_EXPIRED = "common.verify.time.expired";
    String RECORD_NOT_FOUND = "common.record.not.found";

    // user
    String USER_DOES_NOT_EXIST = "user.does.not.exist";
    String USER_ALREADY_DELETED = "user.already.deleted";
    String USER_ALREADY_EXISTS = "user.already.exists";
    String USER_NOT_FOUND = "user.not.found";

    // operation
    String OPERATION_FORBIDDEN = "operation.forbidden";
    String OPERATION_FAILED = "operation.failed";
    String OPERATION_NOT_FOUND = "operation.not.found";
    String OPERATION_ENDED = "operation.ended";
    String OPERATION_STATUS_NOT_SUCCESS = "operation.status.not.success";

    // transaction
    String INVALID_AMOUNT = "transfer.amount.invalid";
    String ALREADY_PAYED_TRANSACTION = "already.payed.transaction";
    String TRANSACTION_NOT_FOUND = "transaction.not.found";
    String TRANSACTION_STATUS_NOT_SUCCESS = "transaction.status.not.success";
    String TRANSACTION_RECEIPT_NOT_FOUND = "transaction.receipt.not.found";

    // business
    String BUSINESS_NOT_FOUND = "business.not.found";
    String BOOK_NOT_FOUND = "book.not.found";

    String BUSINESS_FIELD_NOT_FOUND = "business.field.not.found";

    // role
    String ROLE_ALREADY_EXISTS = "role.already.exists";
    String ROLE_NOT_FOUND = "role.not.found";

    // confirm code
    String CONFIRM_CODE_EXPIRED = "confirm.code.expired";
    String CONFIRM_CODE_ERROR = "confirm.code.error";

    // bank
    String BANK_NOT_FOUND = "bank.not.found";

    // branch
    String BRANCH_NOT_FOUND = "branch.not.found";
    String BRANCH_ALREADY_EXISTS = "branch.already.exists";
    String BRANCH_LIMIT_ALREADY_EXISTS = "branch.limit.already.exists";
    String BRANCH_LIMIT_NOT_FOUND = "branch.limit.not.found";

    // properties
    String PROPERTIES_NOT_FOUND = "properties.not.found";
    String PROPERTIES_ALREADY_EXISTS = "properties.already.exists";

    // message
    String MESSAGE_NOT_FOUND = "message.not.found";
    String MESSAGE_ALREADY_EXISTS = "message.already.exists";
    String AUTHOR_ALREADY_EXISTS = "author.already.exists";

    // enc-dec
    String ERROR_WHILE_DECRYPTING = "error.while.decrypting";
    String ERROR_WHILE_ENCRYPTING = "error.while.encrypting";

    // Ошибка с картой отправителя
    String SENDER_CARD_INVALID = "sender.card.invalid";

    // Неправильная карта
    String CARD_NUMBER_INVALID = "card.number.invalid";
    String CARD_EXPIRE_INVALID = "card.expire.invalid";

    // Ошибка в параметрах
    String PARAMETERS_NOT_VALID = "params.not.valid";
    String PROCESSING_NOT_AVAILABLE_MSG = "processing.not.available";
    String SMS_INFO_NOT_ACTIVE = "sms.info.not.active";
    String INVALID_TOKEN = "invalid.token";
    String EXTERNAL_SERVICE_UNAVAILABLE = "external.service.unavailable";
    String ACCOUNT_TYPE_NOT_VALID = "account.type.not.valid";

    // content
    String SMS_VERIFICATION_MESSAGE_CONTENT = "sms.verification.message.content";

    // telegram
    String TELEGRAM_SETTING_ALREADY_EXISTS = "telegram.setting.already.exists";

}
