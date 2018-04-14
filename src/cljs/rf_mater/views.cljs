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

(defn car-destination-card []
  (let []
    (fn []
      [ui/card {:style {:margin "10px 0px"}}

       	[:div.destination {:style {:padding "5px"
							 				 :display "flex"
							 				 :justify-content "space-between"
                       :align-items "center"}}

        	[ui/card-title {:title "Jańskie Łaźnie"
                        	:subtitle "miejsce docelowe"
                        	:style {:padding "5px"}}]

        	[ui/raised-button {:label "negocjacja"
                           	 :primary true
                           	 :disable false}]]
      	[ui/divider]
	      [:div.day {:style {:padding "5px"
											 :display "flex"
											 :justify-content "space-between"
											 :align-items "center"}}

					[ui/card-title {:title "sobota, 14-04-18"
													:subtitle "dzień wyjazdu"
													:style {:padding "5px"
                     							:font-size "20px"}}]

					[ui/raised-button {:label "negocjacja"
														 :primary true
														 :disable false}]]
       ])))





(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]

     ;[:div [:h1 (str "Hello from " @name ". This is the Home Page.")]
     [ui/mui-theme-provider {:mui-theme (get-mui-theme
                                         ;(aget js/MaterialUIStyles "DarkRawTheme")
                                         )}
     		[:div
       		[app-bar]
       		;[jumbotron]

					[car-destination-card]
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
