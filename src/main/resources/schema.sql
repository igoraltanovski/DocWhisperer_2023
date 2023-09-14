CREATE TABLE registered_flow (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_id BIGINT,
    flow_name VARCHAR(255),
    class_info_json CLOB
);
CREATE TABLE project (
    project_id BIGINT,
    project_name VARCHAR(255),
    class_info_json CLOB
);
CREATE TABLE documentation_template (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(255) NOT NULL,
    template_system VARCHAR(1000),
    template_user VARCHAR(1000)
);