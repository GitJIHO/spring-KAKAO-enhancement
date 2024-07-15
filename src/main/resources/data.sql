-- 유저 추가
INSERT INTO users (email, password)
VALUES ('testuser@example.com', 'password');

-- 카테고리 더미 데이터 추가
INSERT INTO categories (name, color, image_url, description)
VALUES ('교환권', '#6c95d1', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '교환권 카테고리입니다.');
INSERT INTO categories (name, color, image_url, description)
VALUES ('상품권', '#6c95d2', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '상품권 카테고리입니다.');
INSERT INTO categories (name, color, image_url, description)
VALUES ('뷰티', '#6c95d3', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '뷰티 카테고리입니다.');
INSERT INTO categories (name, color, image_url, description)
VALUES ('패션', '#6c95d4', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '패션 카테고리입니다.');
INSERT INTO categories (name, color, image_url, description)
VALUES ('식품', '#6c95d5', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '식품 카테고리입니다.');
INSERT INTO categories (name, color, image_url, description)
VALUES ('리빙/도서', '#6c95d6', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '리빙/도서 카테고리입니다.');
INSERT INTO categories (name, color, image_url, description)
VALUES ('레저/스포츠', '#6c95d7', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '레저/스포츠 카테고리입니다.');
INSERT INTO categories (name, color, image_url, description)
VALUES ('아티스트/캐릭터', '#6c95d8', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '아티스트/캐릭터 카테고리입니다.');
INSERT INTO categories (name, color, image_url, description)
VALUES ('유아동/반려', '#6c95d9', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '유아동/반려 카테고리입니다.');
INSERT INTO categories (name, color, image_url, description)
VALUES ('디지털/가전', '#6c95da', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '디지털/가전 카테고리입니다.');
INSERT INTO categories (name, color, image_url, description)
VALUES ('카카오프렌즈', '#6c95db', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '카카오프렌즈 카테고리입니다.');
INSERT INTO categories (name, color, image_url, description)
VALUES ('트렌드 선물', '#6c95dc', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '트렌드 선물 카테고리입니다.');
INSERT INTO categories (name, color, image_url, description)
VALUES ('백화점', '#6c95dd', 'https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png', '백화점 카테고리입니다.');

-- 제품 더미 데이터 추가 (카테고리와 연관)
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 1', 100, 'image1.jpg', 1);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 2', 200, 'image2.jpg', 2);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 3', 300, 'image3.jpg', 3);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 4', 400, 'image4.jpg', 4);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 5', 500, 'image5.jpg', 5);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 6', 600, 'image6.jpg', 6);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 7', 700, 'image7.jpg', 7);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 8', 800, 'image8.jpg', 8);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 9', 900, 'image9.jpg', 9);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 10', 1000, 'image10.jpg', 10);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 11', 1100, 'image11.jpg', 11);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 12', 1200, 'image12.jpg', 12);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 13', 1300, 'image13.jpg', 1);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 14', 1400, 'image14.jpg', 2);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 15', 1500, 'image15.jpg', 3);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 16', 1600, 'image16.jpg', 4);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 17', 1700, 'image17.jpg', 5);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 18', 1800, 'image18.jpg', 6);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 19', 1900, 'image19.jpg', 7);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 20', 2000, 'image20.jpg', 8);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 21', 2100, 'image21.jpg', 9);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 22', 2200, 'image22.jpg', 10);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 23', 2300, 'image23.jpg', 11);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 24', 2400, 'image24.jpg', 12);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 25', 2500, 'image25.jpg', 1);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 26', 2600, 'image26.jpg', 2);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 27', 2700, 'image27.jpg', 3);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 28', 2800, 'image28.jpg', 4);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 29', 2900, 'image29.jpg', 5);
INSERT INTO products (name, price, img, category_id)
VALUES ('Product 30', 3000, 'image30.jpg', 6);

-- 위시리스트 더미 데이터 추가
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 1, 2);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 2, 4);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 3, 6);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 4, 8);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 5, 10);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 6, 12);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 7, 14);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 8, 16);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 9, 18);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 10, 20);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 11, 22);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 12, 24);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 13, 26);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 14, 28);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 15, 30);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 16, 32);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 17, 34);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 18, 36);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 19, 38);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 20, 40);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 21, 42);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 22, 44);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 23, 46);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 24, 48);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 25, 50);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 26, 52);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 27, 54);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 28, 56);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 29, 58);
INSERT INTO wishes (user_id, product_id, number)
VALUES (1, 30, 60);
