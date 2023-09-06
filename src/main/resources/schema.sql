CREATE TABLE registered_flow (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_id BIGINT,
    flow_name VARCHAR(255),
    class_info_json CLOB
);
