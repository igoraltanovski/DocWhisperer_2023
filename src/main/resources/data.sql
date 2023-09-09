INSERT INTO registered_flow (PROJECT_ID, FLOW_NAME, CLASS_INFO_JSON) VALUES (1, 'FlowName1', '[{"className": "Pet", "methods": ["getPetName()"]}]');
INSERT INTO registered_flow (PROJECT_ID, FLOW_NAME, CLASS_INFO_JSON) VALUES (2, 'FlowName2', '[{"className": "Person", "methods": ["getAge()"]}]');

INSERT INTO project (PROJECT_ID, PROJECT_NAME, CLASS_INFO_JSON) VALUES (1, 'ProjectName1', '[{"className": "Pet", "methods": ["getPetName()", "setAge()"]}]');
INSERT INTO project (PROJECT_ID, PROJECT_NAME, CLASS_INFO_JSON) VALUES (2, 'ProjectName2', '[{"className": "Person", "methods": ["getAge()", "setAge()"]}]');