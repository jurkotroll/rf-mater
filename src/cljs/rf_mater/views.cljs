(ns rf-mater.views
  (:require [cljsjs.material-ui]
   					[re-frame.core :as re-frame]
            [rf-mater.subs :as subs]
    				[cljs-react-material-ui.core :refer [get-mui-theme color]]
    				[cljs-react-material-ui.reagent :as ui]
    				[cljs-react-material-ui.icons :as ic]
    				[reagent.core :as r]
            ))

;; home
; Example with various components




(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]

     ;[:div [:h1 (str "Hello from " @name ". This is the Home Page.")]
     [ui/mui-theme-provider {:mui-theme (get-mui-theme (aget js/MaterialUIStyles "DarkRawTheme"))}
     		[:div
       		[ui/app-bar {:title "Razem Na Stok"
                     	 :showMenuIconButton false
                     	 :titleStyle {:color (color :lime200)
                                    :textAlign :center
                        }}]
       		[ui/paper {:style {:height "100"
                             :width "100%"
  													 :margin-top "10"
                             :textAlign "center"
                             :display "inline-block"
                            }
                     :zDepth "3"}]
        		;[:a {:href "#/about"} "go to About Page"]


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
