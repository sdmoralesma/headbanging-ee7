INSERT INTO `user` (`user_id`, `username`, `user_type`, `group_name`, `password`)
VALUES (1, 'admin1', 'admin', 'admin', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg='),
  (2, 'jury1', 'jury', 'jury', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg='),
  (3, 'participant1', 'participant', 'participant', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=');

INSERT INTO `admin` (admin_id, admin_info) VALUES (1, 'A great admin');

INSERT INTO `jury` (jury_id, jury_info) VALUES (2, 'the great Jury1');

INSERT INTO `participant` (participant_id, age, gender, image_url, song, total_score)
VALUES (3, 18, 'MALE', 'http://www.oracle.com/ocom/groups/public/@ocom/documents/digitalasset/427163.jpg', 'a song', 0.0);
