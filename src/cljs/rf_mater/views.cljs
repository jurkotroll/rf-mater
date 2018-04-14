(ns rf-mater.views
  (:require [cljsjs.material-ui]
   					[re-frame.core :as re-frame]
            [rf-mater.subs :as subs]
    				[cljs-react-material-ui.core :refer [get-mui-theme color]]
    				[cljs-react-material-ui.reagent :as ui]
    				[cljs-react-material-ui.icons :as ic]
    				[reagent.core :as r]
            [garden.core :refer [css]]
            ))

;; home
; Example with various components
(defn app-bar []
  (let []
    [ui/app-bar {:title "Razem Na Stok"
								 :showMenuIconButton false
								 :titleStyle {:color (color :lime200)
															:textAlign :center
									}}]))

(defn jumbotron []
  (let []
    [ui/paper {:style {:height "200px"
											 :width "auto"
											 ;:max-width "40%"
											 :margin "10px 0px"
											 :textAlign "center"
											 :display "flex"
											}
							 :zDepth "1"}]))



(defn new-card [{:keys [title subtitle]}]
  (let [
        ;title (:title titles) subtitle (:subtitle titles)
        ]
    [ui/card {:style {:height "auto"
                      :width "auto"
                      :margin "10px 0px"}}
     [ui/card-header {:title title
                      :subtitle subtitle}]]))

(defn car-card []
  (let []
    (new-card {:title "Nazwa"
               :subtitle "numer porządkowy auta"})))

(defn new-passanger-card []
  (let []
    (new-card {:subtitle "dodaj pasażera"})))

(defn list-of-passangers []
  (let []
    (new-card {:title "Kto już w aucie"})))

(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]

     ;[:div [:h1 (str "Hello from " @name ". This is the Home Page.")]
     [ui/mui-theme-provider {:mui-theme (get-mui-theme
                                         ;(aget js/MaterialUIStyles "DarkRawTheme")
                                         )}
     		[:div
       		[app-bar]
       		[jumbotron]
					[car-card]
       		[new-passanger-card]
       		[list-of-passangers]
        	[:a {:href "#/about"} "go to About Page"]


        ]
      ]
     ))


;; about

(defn about-panel []
  [:div "This is the About Page."
   [:div [:a {:href "#/"} "go to Home Page"]]])


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
