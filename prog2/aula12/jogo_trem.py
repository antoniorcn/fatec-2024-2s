import pygame
from pygame.locals import QUIT, K_SPACE, K_a, K_d, K_e, KEYDOWN
from trem import Trem

pygame.init()
pygame.mixer.init()

som=pygame.mixer.Sound("./piui.wav")
screen = pygame.display.set_mode( (800, 600), 0, 32)
trem_img = pygame.image.load("trem.jpg").convert()
trem_img_escalado = pygame.transform.scale(trem_img, (150, 100))
rosana = Trem()
pos_x = 100

while True:
    # calcular regras
    pos_x = pos_x + rosana.velocidade

    # mostrar na tela
    screen.fill( (0, 0, 0) )
    screen.blit(trem_img_escalado, (pos_x, 100))
    pygame.display.update()

    # capturar eventos
    for evento in pygame.event.get():
        if evento.type == QUIT:
            exit()
        if evento.type == KEYDOWN:
            if evento.key == K_e:
                rosana.apitar()
                pygame.mixer.Sound.play(som)
            elif evento.key == K_a:
                rosana.frear()
            elif evento.key == K_d:
                rosana.acelerar()



