import pygame
from pygame.locals import QUIT,\
K_RIGHT, K_LEFT, K_UP, K_DOWN,\
KEYDOWN, KEYUP
from pygame.rect import Rect
from random import randint

# Cores utilizadas no JOGO
AMARELO = (255, 255, 0)
PRETO = (0, 0, 0)
ROXO = (255, 0, 255)
VERMELHO = (255, 0, 0)


# Funções para teste de colisão
def intercalou(min_a, max_a, min_b, max_b):
    return (min_a <= min_b and max_a >= min_b) or\
    (max_b >= min_a and max_b <= max_a)

def colisao_rect( rect_a, rect_b):
    min_a = rect_a[0][0]
    max_a = min_a  + rect_a[1][0]
    min_b = rect_b[0][0]
    max_b = min_b  + rect_b[1][0]
    colidiu_x = intercalou(min_a, max_a, min_b, max_b)
    min_a = rect_a[0][1]
    max_a = min_a  + rect_a[1][1]
    min_b = rect_b[0][1]
    max_b = min_b  + rect_b[1][1]
    colidiu_y = intercalou(min_a, max_a, min_b, max_b)
    return colidiu_x and colidiu_y

pygame.init()
screen = pygame.display.set_mode( (800, 600), 0, 32 )

img_bob = pygame.image.load("./bob_squarepants.png")
img_personagem = pygame.transform.scale(img_bob, (50, 50))

img_squid1 = pygame.image.load("./squidward_1.png")
img_lula1 = pygame.transform.scale(img_squid1, (150, 300))
img_squid2 = pygame.image.load("./squidward_2.png")
img_lula2 = pygame.transform.scale(img_squid2, (150, 300))
img_squid3 = pygame.image.load("./squidward_3.png")
img_lula3 = pygame.transform.scale(img_squid3, (150, 300))
img_burguer1 = pygame.image.load("./siri_burguer.png")
img_krabburguer = pygame.transform.scale(img_burguer1, (50, 50))

x = 400.0
vx = 0.0
y = 300.0
vy = 0.0
cor_personagem = AMARELO
retangulo_inimigo1 = ((randint(0, 700), randint(0, 500)),
                          (100, 100))
while True:
    # Calcular Regras
    x = x + vx
    y = y + vy
    retangulo_personagem = ( (x, y), (50, 50) )
    retangulo_bonus = ( (500, 180), (50, 50) )
    cor_personagem = AMARELO
    if colisao_rect(retangulo_personagem, retangulo_bonus):
        cor_personagem = VERMELHO
    if colisao_rect(retangulo_personagem, retangulo_inimigo1):
        cor_personagem = VERMELHO
    
    # Desenhar
    screen.fill( PRETO )
    # pygame.draw.rect( screen, cor_personagem, retangulo_personagem, 0)
    screen.blit(img_personagem, dest=Rect(retangulo_personagem))
    # pygame.draw.rect( screen, ROXO, retangulo_bonus, 0)
    screen.blit(img_krabburguer, dest=Rect(retangulo_bonus))
    # pygame.draw.rect( screen, VERMELHO, retangulo_inimigo1, 0)
    screen.blit(img_lula3, dest=Rect(retangulo_inimigo1))
    pygame.display.update()

    # Capturar Eventos
    for event in pygame.event.get():
        if event.type == QUIT:
            exit(0)
        elif event.type == KEYDOWN:
            if event.key == K_RIGHT:
                vx = 0.1
            elif event.key == K_LEFT:
                vx = -0.1
            elif event.key == K_UP:
                vy = -0.1
            elif event.key == K_DOWN:
                vy = 0.1                
        elif event.type == KEYUP:
            if event.key in [K_RIGHT, K_LEFT]:
                vx = 0.0
            if event.key in [K_UP, K_DOWN]:
                vy = 0.0