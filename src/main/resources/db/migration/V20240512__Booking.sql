CREATE TABLE booking (
    id VARCHAR(36) PRIMARY KEY,
    room_id VARCHAR(36),
    meeting_topic VARCHAR(50) NOT NULL,
    pic VARCHAR(50) NOT NULL,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    CONSTRAINT FK_Room FOREIGN KEY (room_id) REFERENCES room(id)
);

INSERT INTO booking VALUES('9f719191-154a-46bd-9df6-b93a747c2020', 'c65f1f33-61de-438a-a7df-d3b860cb5276', 'Java Training', 'James Gosling', '2024-01-13 13:00', '2024-01-13 14:30');
INSERT INTO booking VALUES('38022736-91f5-4677-a8b4-ef7716f0743e', 'c65f1f33-61de-438a-a7df-d3b860cb5276', 'Spring Boot Training', 'Rod Johnson', '2024-01-14 13:00', '2024-01-14 14:30');
INSERT INTO booking VALUES('ebd007ca-b366-4ed6-a2e1-41120550d31c', 'c65f1f33-61de-438a-a7df-d3b860cb5276', 'Cybersecurity Training', 'John McAfee', '2024-01-14 15:00', '2024-01-14 17:00');
