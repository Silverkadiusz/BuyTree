INSERT INTO category(id, name, description)
VALUES (1, 'Elektronika', 'Fajne przedmioty'),
       (2, 'AGD', 'sprzet gospodarstwa domowego'),
       (3, 'Moto', 'Samochody, skutery i ciezarowki'),
       (4, 'Moto', 'Kategoria usunięta');

INSERT INTO offer(title, description, price, category_id, img_url)
VALUES
    ('Telewizor Samsung', 'Super TV', 2499.90, 1, 'https://images.samsung.com/is/image/samsung/au-n5300-ua32n5300awxxy-frontblack-173631427?$720_576_PNG$'),
    ('Smartwatch', 'Mądry zegarek', 1299.90, 1,
     'https://a.allegroimg.com/s512/03eb97/379feacf4f12876188959764c4fb/Smartwatch-damski-KW10-OLED-DESIGN-kroki-puls-cykl-Model-KW10'),
    ('Mikrofalówka', 'Podgrzej se jedzonko', 429.90, 2,
     'https://i5.walmartimages.com/asr/a67a1e6f-817e-4b27-9331-570e1805ac68_1.e83a8d64215f76d7c45821ca96dc16f8.jpeg?odnWidth=612&odnHeight=612&odnBg=ffffff')
;
