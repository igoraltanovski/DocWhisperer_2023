INSERT INTO registered_flow (PROJECT_ID, FLOW_NAME, CLASS_INFO_JSON) VALUES (1, 'add_vet', '[{"className": "Pet", "methods": ["getPetName()"]}]');
INSERT INTO registered_flow (PROJECT_ID, FLOW_NAME, CLASS_INFO_JSON) VALUES (2, 'get_pet', '[{"className": "Person", "methods": ["getAge()"]}]');
INSERT INTO registered_flow (PROJECT_ID, FLOW_NAME, CLASS_INFO_JSON) VALUES (3, 'update_pet', '[{"className": "Person", "methods": ["getAge()"]}]');

INSERT INTO project (PROJECT_ID, PROJECT_NAME, CLASS_INFO_JSON) VALUES (1, 'ProjectName1', '[{"className": "Pet", "methods": ["getPetName()", "setAge()"]}]');
INSERT INTO project (PROJECT_ID, PROJECT_NAME, CLASS_INFO_JSON) VALUES (2, 'ProjectName2', '[{"className": "Person", "methods": ["getAge()", "setAge()"]}]');

INSERT INTO documentation_template (type, template_system, template_user)
VALUES
('TECHNICAL',
 'Channel the experience and knowledge of a senior developer and technical writer. Given the code or technical topic below, provide a detailed, comprehensive, and technically accurate explanation, walkthrough, or documentation, as if explaining to a fellow developer. Make sure to address nuances, best practices, and potential pitfalls.',
 'Given the code provided below, generate a concise yet comprehensive documentation based on the following topic model:\n\nFunctionality Overview: A brief description of what the code does .\nUsage: How to use or implement the code.\nParameters and Returns: Details about the input parameters and return values.\n\n');

INSERT INTO documentation_template (type, template_system, template_user)
VALUES
('BUSINESS',
 'Channel the experience and knowledge of a senior business analyst with strong technical knowledge. Given the business or technical topic below, provide a detailed, comprehensive, and technically accurate explanation, walkthrough, or documentation, as if explaining to a fellow business analyst. Make sure to address nuances, best practices, and potential pitfalls.',
 'Abstract: Generate a straightforward business document focusing on the core essentials of business flow and value and DON''T include any code. This template should serve as a comprehensive guide for stakeholders of all levels.\n\nRequirements:\n\nBusiness Overview: A concise introduction to the business, its primary objectives, and operations.\n\nBusiness Flow: Description of core processes, their interactions, and significance in layman''s terms.\n\nBusiness Value: Breakdown of the direct and indirect benefits each process brings to the enterprise.\n\nRisks and Challenges: Identification of potential hurdles in the business flow and strategies to overcome them.\n\nthe code:\n');
